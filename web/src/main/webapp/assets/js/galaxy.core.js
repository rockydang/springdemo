/**
 * wuwei
 */
/* 序列化表单到 json object */
jQuery.fn.serializeJson = function(includeDisable) {
	var serializeObj = {};
	var array = this.serializeArray();
	if(includeDisable){
		$(':disabled[name]', this).each(function () { 
			array.push({ name: this.name, value: $(this).val() });
		});
	}
	var str = this.serialize();
	$(array).each(function() {
		if (serializeObj[this.name]) {
			if ($.isArray(serializeObj[this.name])) {
				serializeObj[this.name].push(this.value);
			} else {
				serializeObj[this.name] = [ serializeObj[this.name], this.value ];
			}
		} else {
			serializeObj[this.name] = this.value;
		}
	});
	return serializeObj;
};

window.dg = null;

window.contextpath = null;

Galaxy = {

    /**
	 * 关闭LHG的对话框
	 */
    closeLhgDialog: function() {
	    document.documentElement.style.overflow = 'visible';
	    window.dg.closeTime(0.1);
    },
    /**
	 * 锁定父容器页面
	 */
    lockLhgContextWin: function() {
	    document.documentElement.style.overflow = 'hidden';
    },

    formatDate: function formatDate(time) {
	    var date = new Date(parseInt(time) * 1000);
	    var month = date.getMonth() + 1;
	    var day = date.getDate();
	    return month + "-" + day + "";
    },

    BindLiveTip: function() {
	    $(window).bind('beforeunload', function() {
		    return '内容尚未保存，确定离开此页面吗？';
	    });
    },

    UnBindWindowLive: function() {
	    $(window).unbind('beforeunload');
    },
    /**
     * 刷新页面
     */
    reload: function(){
    	location = location;
    },
    /**
     * 刷新父页面
     */
    reloadParent: function(){
    	parent.location = parent.location;
    },
    /**
     * alert
     * @param message
     * @param time
     */
    alert: function(message, time){
    	var b = bootbox.alert({
			size: 'small',
			message: message || ''
		});
		setTimeout(function(){
			Galaxy.closeBox(b);
		}, time || 1500);
    },
	/**
	 * 刷新父页面
	 */
	reloadParentFunction: function(funcId){
		parent.$(funcId).trigger("click");
	},
    closeBox: function(box){
    	box.trigger("escape.close.bb");
    },
    /**
	 * 弹出页
	 * 
	 * @param src
	 *            目标地址 相对当前页路径或者全路径 不能跨域跳转
	 * @param width
	 * @param height
	 */
    popup: function(src, width, height){
    	width = width || 800;
    	height = height || 500;
    	Custombox.open({
    		effect: 'blur',
    		target: src + '&width=' + width + '&height=' + height,
    		width: width,
    		height: height
    	});
    },
    
    ajax: function(type, url, dataType, data, contentType, sc, fc, ec){
    	jQuery.ajax({
    		type : type,
    		url : url,
    		dataType : dataType,
    		data : data, 
    		contentType: contentType,
    		success : function(data) {
    			if(data.success)
    			{
    				if(typeof sc == 'function'){
    					sc(data.value);
    				}else if(sc){
    					try{
    						var b = bootbox.alert({
    							size: 'small',
    							message: '操作执行成功'
    						});
    						setTimeout(function(){
    							b.trigger("escape.close.bb");
    						}, 1500);
    					}catch(e){}
    				}
    			}else{
    				if(typeof fc == 'function'){
    					fc(data.errorMsg);
    				}else if(fc){
    					try{
    						bootbox.alert({
    							size: 'small',
    							message: errorMsg
    						});
    					}catch(e){}
    				}
    			}
    		},
    		error : function(XMLHttpRequest, textStatus, errorThrown) {
    			if(typeof ec == 'function'){
    				ec(textStatus);
    			}else if(ec){
    				try{
    					bootbox.alert({
    						size: 'small',
    						message: '后台执行发生错误！'
    					});
    				}catch(e){}
    			}
    		}
    	});
    },
    /**
     * 以json提交
     */
    postPayload: function(url, data, sc, fc, ec){
    	Galaxy.ajax('post', url, 'json', data, 'application/json;charset=UTF-8', sc, fc, ec);
    },
    /**
     * 以x-www-form-urlencoded提交
     */
    postFormData: function(url, data, sc, fc, ec){
    	Galaxy.ajax('post', url, 'json', data, 'application/x-www-form-urlencoded;charset=UTF-8', sc, fc, ec);
    },
    
    postUrl: function(url, data, sc, fc, ec){
    	Galaxy.ajax('post', url + '?' + $.param(data), 'json', null, 'application/x-www-form-urlencoded;charset=UTF-8', sc, fc, ec)
    }
    
}

// wuwei 谷歌浏览器第一次会出现无法滚动的情况 兼容chrome
document.addEventListener(
	'custombox.complete',
	function(){
		try{
			$('#popup_d').css('display', 'block');
		}catch(e){}
	}
);