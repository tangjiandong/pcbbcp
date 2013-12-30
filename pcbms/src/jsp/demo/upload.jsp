<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OA管理系统</title>
<link type="text/css" rel="stylesheet" href="../../css/uploadify.css">

</head>
<body>

	<!-- 上传例子 -->
	<img src="../images/cancel.png" height="60" id="img_shop_logo">

	<div class="file_btn">
		<input name="uploadify" id="uploadify" type="file">
		<div id="div_progress"></div>
	</div>
	<script type="text/javascript" src="../js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="../js/jquery.uploadify.v2.0.3.js"></script>
	<script type="text/javascript" src="../js/swfobject.js"></script>
	<script type="text/javascript">
    
        $("#uploadify").uploadify({
	 	       'uploader': '../images/uploadify.swf', 
	 	       'script': 'fileUpload.do?type=pic', //上传LOGO图片【如果需要上传产品图片,需修改为：flag=product】
	 	       'fileDataName':'file',  
	 	       'cancelImg': '../images/cancel.png', 
	 	       'queueID': 'div_progress', 
	 	       'queueSizeLimit':1, 
	 	       'fileDesc' : 'jpg、gif、jpeg、png文件', 
	 	       'fileExt' : '*.jpg;*.gif;*.png;*.jpeg', 
	 	       'auto' : true,  
	 	       'multi' : false, 
	 	       'simUploadLimit' : 1, 
	 	       'sizeLimit':5120000, 
	 	       'buttonText': '上传图片', 
	 	       'displayData': 'percentage', 
	 	       'onComplete': function (evt, queueID, fileObj, response, data){
	 	        	var v_img_path=$.trim(response);
	 	        	alert(v_img_path);
	        	  $("#img_shop_logo").attr("src",v_img_path);
	 	       },
	 	       'onError' : function(event, queueID, fileObj,errorObj){
	 	    	   alert(1);
	 	    	   if(errorObj.type === "File Size"){
	 	    		 // alert("图片最大尺寸为500K");
	 	    		 $('#error_msg').html('<span><img src="../../images/error.gif">图片最大尺寸为500K！</span>');
    			     $('#error_msg').show(300).delay(3000).hide(300);
	 	    		 $("#uploadify").uploadifyClearQueue();
	 	    	   }
	 		   },
	 		   'onQueueFull':function(event,queueSizeLimit){
	 				//alert("最多同时上传"+queueSizeLimit+"张图片");
	 			    return false;
	 		   }
	 	    }); 
	        
	    

  </script>

</body>
</html>