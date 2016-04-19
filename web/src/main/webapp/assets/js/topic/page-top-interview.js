(function($){
    var noteload=false;
    $(document).ready(function($) {
        // var audio5js = [];
        // $('.play').each(function(i,value){
        //     var play = $(this);
        //     var audio = {};
        //     var time = play.find('.playTime');
        //     var audioSrc = play.attr('src');
        //     var curTimeBox = time.find('span');
        //     var audioDur = curTimeBox.html();
        //     // var playPause = function (index) {

        //     //     $.each(audio5js,function(){
        //     //         this.pause();
        //     //     })
        //     //     audio5js[index].play();
        //     //     // if (this.playing) {
        //     //     //   this.pause();
        //     //     // } else {
        //     //     //   this.play();
        //     //     // }
        //     //     play.toggleClass('btn_pause');
        //     // };

        // var audioReady = function () {
        //     //this points to the Audio5js instance
        //     // this.load(audioSrc);
        //     this.on('ended', function () {
        //       // play.removeClass('btn_pause');
        //     }, this);
        //     // timeupdate event passes audio
        //     // duration and position to callback
        //     this.on('timeupdate', function (position, duration) {
        //       // curTimeBox.html(position);
        //       // audio.duration = duration;
        //     }, this);

        //     // progress event passes load_percent to callback
        //     this.on('progress', function (load_percent) {
                
        //     }, this);
        //     // play.on('click',function(){
        //     //     // $.each(audio5js,function(){
        //     //     //     this.pause();
        //     //     // })
        //     //     // this.play();
        //     //     // if (this.playing) {
        //     //     //   this.pause();
        //     //     // } else {
        //     //     //   this.play();
        //     //     // }
        //     //     play.toggleClass('btn_pause');
        //     // }

        //     // );
        //     //error event passes error object to callback
        //     this.on('error', function (error) {
        //       console.log(error.message);
        //     }, this)
        // }

        //     audio5js[i] = new Audio5js({
        //         ready: audioReady
        //     });
        //     console.log(audio5js);
        // };
        // var audio5js = new Audio5js({
        //     ready: function(){}
        // });

        // $('.play').click(function(){
        //     var play = $(this);
        //     var url = play.attr('src');
        //     if(audio5js.playing){
        //         // audio5js.pause();
        //         audio5js.load(url);
        //         audio5js.play();
        //         // alert(url);
        //     }
            
        //     // alert(url);
        //     audio5js.load(url);
        //     audio5js.play();
        // });
        

        // @yefei 2014-01-13  页面滚动后header固定 
        // function fixHeader(){
        //     // console.log($('body').scrollTop());
        //     // console.log(.scrollTop());
        //     if($('body').scrollTop() > 180){
        //         $('.j_scroll').fadeIn('slow');
        //     }else {
        //         $('.j_scroll').fadeOut('600');
        //     }
        // }
        // $(window).on('scroll',function(){
        //     fixHeader();
        // });
// @yefei 2014-01-15  页面语音播放功能实现
    // if(navigator.userAgent.match(/iPhone/i) ) {
    //     var playBtn = $(".play");
    //     var audio = [];
    //     function showtime() {
    //         var remain = this.duration - this.currentTime; //剩余时间
    //         if (remain) {
    //             $(this).parent().find('.playTime span').html(parseInt(remain) + "''");// 更新剩余播放时间显示
    //         } else {
    //             $(this).parent().find('.playTime span').html( parseInt(this.duration) + "''");// 播放完之后显示音频长度
                    
    //             playBtn.removeClass('btn_pause');
    //         }
    //     }
    //     playBtn.each(function(i,item){
    //         audio[i] = $(item).find('.audioPlay')[0];
    //         (function(n, btn){
    //             $(btn).bind('click',function(){
                    
    //                 $(audio[i]).bind("timeupdate", showtime);
    //                 var btn = $(this);

    //                 var playTime = btn.find('.playTime');
                   
    //                 $(audio).each(function(index,data){
                        
    //                     if(index !== n){
    //                         data.pause();
    //                         playBtn.removeClass('btn_pause');
    //                     }
    //                 });
    //                 if (audio[n].paused) {
    //                     audio[n].play();
    //                     btn.addClass('btn_pause');
    //                 }else {
    //                     audio[n].pause();
    //                     btn.removeClass('btn_pause');
    //                 }
    //             })
    //         })(i, item); 
    //     });
    // }
    // else {
    //     $('.j_audio').hide();
    // }

        //初始化评论
        getNote();
        //初始化给每个大图的链接加id
        initImg();
        //显示大图加hash模拟history
        $(".grid a").click(function(ev){
            if(this.id!=""){
                window.location.hash="!big"+this.id;
                return false;
            }
        });
        //显示大图
        $(window).on("hashchange",showBigImg);
        $(".imgmask").live("click",function(ev){
            window.location.hash="!";
            return false;
        });
        $(".note_mask").click(function(ev){
            if(window.location.hash !=""){
                window.location.hash="!";
                return false;
            }

        });
        //加载更多评论
        $(window).bind("scroll",noteMore);
        //显示评论
        $(".note_more").bind('click', function(event) {
            getNote();
        });
        //评论
        $(".note_btn").click(function(event) {
            event.preventDefault();
            showMask();
            $(".note_page").css("top",$(this).offset().top-180);
            $(".note_page").show();
            $("#note_text").val("").focus();
        });
        $(".note_page .note_close").click(function(event) {
            event.preventDefault();
            $(".note_page").hide();
            hideMask();
        });
        
        //评论添加
        $("#note_text").bind("keyup",function(event) {
            if(!$(".note_sub").hasClass('enable') && $(this).val()!="")
                $(".note_sub").addClass('enable')
            else if($(".note_sub").hasClass('enable') && $(this).val()=="")
                $(".note_sub").removeClass('enable');
            var text=140-$(this).val().length;
            $(this).siblings('span').html(140-$(this).val().length);
        });
        //评论提交
        $(".note_sub").click(function(event) {
            if(!$(".note_sub").hasClass('enable'))
                return false;
            if($("#note_text").val().length>140){
                Tips("输入文字不能超过140字哦~");
                return false;
            }
            var twitterid=$(".note").attr("tid");
            $.ajax({
                type:'POST',
                url:'/top/selection/addcomment',
                data:{'tid':twitterid, 'content':$("#note_text").val()},
                dataType:'json',
                success:function (json) {
                    if(json.status.code && json.status.code==1001){
                        if($(".note_no").css("display")!="none")
                        {
                            $(".note_no").hide();
                            $(".note_more").css("display","block");
                        }
                        refueNote(json.result);
                        hideMask();
                        $(".note_page").hide();
                    }else{
                        if(json){
                            Tips(json.status.msg);
                        }else{
                            Tips("网络异常");
                        }
                    }
                }
            });
        });
        //分享
        $(".share li a").click(function(ev){
            ev.preventDefault();
            if($(this).hasClass("disabled"))return false;
            share(this.id);
        });
    });
    function initImg(){
        $(".grid a").each(function(index){
            if(/mogujie.cn\/pic/.test($(this).attr("href"))){
                $(this).attr("id","img"+index);
            };
        })
    };
    function showBigImg(ev){
        var hash=window.location.hash.replace("!big","");
        hash =(hash.charAt(0) != '#') ? '#'+hash:hash;
        if(hash!="#!" && $(hash).length>0)
        {
            showMask();
            showload();
            var clientHeight= window.innerHeight,
                clinetWidth= window.innerWidth,
                imgclone= new Image();
            $(".wrapper").append(imgclone);
            imgclone.onload=function(){
                var imgWidth=this.naturalWidth,
                    imgHeight=this.naturalHeight;
                if(imgWidth/imgHeight > clinetWidth/clientHeight){
                    $(this).css("width",clinetWidth+"px").css("height",parseInt(clinetWidth*(imgHeight/imgWidth))+ "px");
                }else{
                    $(this).css("height",clientHeight+"px").css("width",parseInt(clientHeight*(imgWidth/imgHeight))+ "px");
                    $(this).css("left",parseInt((clinetWidth- clientHeight*(imgWidth/imgHeight))/2)+ "px");
                }
                var height=$(this).height();
                $(this).addClass("imgmask").css('top',(clientHeight - height)/2+"px").show();
                hideload();
            };
            imgclone.src=$(hash).attr("href");
        }else{
            if($(".imgmask").length>0)
            {
                $(".imgmask").hide().remove();
                hideMask();
            }
        }
        return false
    };
    function noteMore(){
        if($('body').scrollTop() > 180){
            $('.j_scroll').fadeIn('400');
        }else {
            $('.j_scroll').fadeOut('400');
        }
        if($(".note_more").length<=0)
            return false;
        var top = $(".note_more").offset().top;
        if(!noteload && $(window).scrollTop() + $(window).height() > top ){
            getNote();
        }
    };

    function getNote(){
        noteload=true;
        var twitterid=$(".note").attr("tid"),
            lastid=$(".note_list").attr("lid")?$(".note_list").attr("lid"):0;
        $.ajax({
            type:'GET',
            url:'/top/selection/getcomments',
            data:{'tid':twitterid, 'lastId':lastid},
            dataType:'json',
            success:function (json) {
                if(json.status.code && json.status.code==1001){
                    var list = json.result.comments;
                    for(var i in list){
                        refueNote(list[i],1);
                    }
                    noteload=false;
                    if(list.length > 0 && $(".note_no").css("display")!="none")
                    {
                        $(".note_no").hide();
                        $(".note_more").css("display","block");
                    }
                    if(json.result.lastId)
                        $(".note_list").attr("lid",json.result.lastId);
                    if(json.result.isEnd=="1"){
                        // $(window).unbind("scroll");
                        $(".note_more").unbind("click").remove();
                    }
                }else{
                    if(json){
                        Tips("异常")
                    }else{
                        Tips(json.status.msg);
                    }
                }
            }
        });
    };
    //渲染评论
    function refueNote(list,order){
        var noteorder= order ? order : -1;
        var person=$("<div class='note_person'></div>").append(
                ['<a href="'+list.user.homeUrl+'" >',
                    '<img src="'+list.user.avatar+'" alt="'+list.user.uname+'"/>',
                    '</a>',
                    (list.user.isDaren?"<i></i>":"")].join("")),
            note=$('<div class="note_txt"></div>').append(
                ['<h5>'+list.user.uname+'</h5>',
                    '<p>'+list.content+'</p>'
                ].join(""));
        if(noteorder<0)
            $(".note_list").prepend($("<li></li>").append(person).append(note));
        else
            $(".note_list").append($("<li></li>").append(person).append(note));
    };
    function showMask(){
        var _height=window.innerHeight;
        $("body").css("height",_height).css("overflow","hidden");
        $(".note_mask").css("height",document.documentElement.scrollHeight).show()
        $("html").bind("touchmove",function(ev){
            ev.preventDefault();
        })
    };
    function hideMask(){
        $("body").attr("style","");
        $(".note_mask").hide();
        $("html").unbind("touchmove");
    };
    function showload(){
        var loaditem=$('<div class="loadcl"></div>');
        $("body").append(loaditem);
        loaditem.show();
    };
    function hideload(){
        if($('.loadcl').length>0)
            $('.loadcl').hide().remove();
    };
    function Tips(text){
        var $el=$('<div class="errortips"></div>');
        $el.html(text);
        $("body").append($el);
        var width = $el.width();
        $el.css("left",(window.innerWidth - width)/2+"px").show();
        setTimeout(function(){
            $el.hide();
        },2000)
    };
    function share(type){
        var baseurl={
            sina:"http://v.t.sina.com.cn/share/share.php?appkey=1010663281",
            qzone:"http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?"
        };

        var option = {
            url:location.href,
            title:document.title,/*分享标题(可选)*/
            desc:'',/*默认分享理由(可选)*/
            summary:$(".grid").find(".g_text").text(),/*分享摘要(可选)*/
            site:"http://"+location.host+"/top/share/selection?id="+$("#defaultid").val(),/*分享来源 如：腾讯网(可选)*/
            pic:$("#defaultimg").val() /*分享图片的路径(可选)*/
        };
        var url=baseurl[type];
        switch(type){
            case "sina":
                url +=[//'&url=',encodeURIComponent(option.site),
                    '&title=',encodeURIComponent(option.title+" "+option.site+"（@Top官方微博）"),
                    '&content=','gb2312',
                    '&pic=',encodeURIComponent(option.pic)
                ].join('');
                break;
            case "qzone":
                url +=['url=',encodeURIComponent(option.site),
                    '&showcount=1',
                    '&title=',encodeURIComponent(option.title+" "+option.site+"（@Top官方微博）"),
                    '&site=',encodeURIComponent(option.site),
                    '&summary=',encodeURIComponent(option.summary),
                    '&pics=',encodeURIComponent(option.pic)
                ].join('');
                break;
        }
        openpage(url);
        function openpage(url){
            if(!window.open(url,'mb',['toolbar=0,status=0,resizable=1,width=600,height=430,left=',(screen.width-440)/2,',top=',(screen.height-430)/2].join('')))
                location.href=url;
        };

    };
})(jQuery)