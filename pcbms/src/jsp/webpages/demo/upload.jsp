<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>OA管理系统</title>
	 <link type="text/css" rel="stylesheet" href="../../css/uploadify.css">
	 <link type="text/css" rel="stylesheet" href="../../css/default.css"></link>

</head>
<body>
		<img src="../images/cancel.png" height="60" id="img_shop_logo">
    
           <div class="file_btn"><input  name="uploadify" id="uploadify"  type="file">
                               <div id="div_progress"></div> 
				 </div>
	<script type="text/javascript" src="../../js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="../../js/jquery.uploadify.v2.0.3.js"></script>
<script type="text/javascript" src="../../js/swfobject.js"></script>
       <script type="text/javascript" >
       $("#uploadify").uploadify({
           'uploader': '../../images/uploadify.swf', //flash文件的相对路径
           'script': 'newUpload!uploadImage.do?flag=picture', //上传产品图片【如果需要上传品牌Logo,需修改为： UPLOAD_LOGO_SERVICE. 详细参见dtun_config.js文件】
           'fileDataName':'file', //设置上传文件名称,默认为Filedata
           'cancelImg': '../../images/cancel.png', //每一个文件上的关闭按钮图标
           'queueID': 'div_progress', //文件队列的ID，该ID与存放文件队列的div的ID一致
           'queueSizeLimit':1, //当允许多文件生成时，设置选择文件的个数，【默认值：999】
           'fileDesc' : 'jpg、gif、jpeg、png文件', //用来设置选择文件对话框中的提示文本        'jpg、gif、jpeg、png文件'
           'fileExt' : '*.jpg;*.gif;*.png;*.jpeg', //设置可以选择的文件的类型 '*.jpg;*.gif;*.png;*.jpeg'
           'auto' : true, //设置为true当选择文件后就直接上传了，为false需要点击上传按钮才上传
           'multi' : false, //设置为true时可以上传多个文件
           'simUploadLimit' : 1, //允许同时上传的个数 【默认值：1】 
           'sizeLimit':2048000, //上传文件的大小限制 【单位byte】
           'buttonText': '上传图片', //浏览按钮的文本，默认值：BROWSE
           'displayData': 'percentage',//上传队列显示的数据类型【percentage：百分比，speed：上传速度】
           //选择上传文件后调用
           'onSelect': function(evt, queueID, fileObj) {  
           		//$("#imguploadify").uploadifySettings("script", 'upload!uploadImage.do?flag=picture&fileName='+fileObj.name+'&userid='+${loginUserMajorId});
      
            },
             //回调函数
           'onComplete': function (evt, queueID, fileObj, response, data){
           		//var jsObject = eval('('+response+')'); 
           			var jsObject = eval('('+response+')'); 
					alert(jsObject[0].imgUrl);
           		
           		
           },
           'onError' : function(event, queueID, fileObj,errorObj){
        	   if(errorObj.type === "File Size"){
        		  alert("图片最大尺寸为2M");
        		  $("#imguploadify").uploadifyClearQueue();
        	   }
    	   },
    	   'onQueueFull':function(event,queueSizeLimit){
    			alert("最多同时上传"+queueSizeLimit+"张图片");
    		    return false;
    	   }
        });
	        
	    

  </script>
    
</body>
</html>