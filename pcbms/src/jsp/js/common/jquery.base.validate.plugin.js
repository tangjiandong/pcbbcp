
/*
*
*********************** jquery 常用的验证信息  ************************************
*
*/
jQuery.base = {  
		/**
		 * 根据规则判断字符串是否符合
		 * @param str
		 * @param reg
		 * return true/false;
		 */
		regexp:function(v_str,v_reg) {        
			var reg = new RegExp(v_reg);
			return reg.test(v_str);
		},
		/** 统计字符长度 string
		 */ 
		strlength: function (str) {  //在IE8 兼容性模式下 不会报错  
			if (typeof(str) == "undefined") { 
			    return 0;
			}  
			str=$.trim(str);
		   if(str==""){ 
			      return 0; 
			  } 
		  if(str=="" ||str==null){ 
		      return 0; 
		   } 
	       var s = 0;  
	       for(var i = 0; i < str.length; i++) {  
	           if(str.charAt(i).match(/[\u0391-\uFFE5]/)) {  
	                s += 2;     
	           } else {  
	              s++;  
	           }  
	       }  
	       return s;  
		},
		/*** 判断邮箱是否正确 ****/
		isEmail:function(obj){
			 var reg  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			return  reg.test(obj);
		},
		/*** 判断手机号是否正确 ****/
		isTelephone:function(obj){
			   var mobile = /^(((18[0-9]{1})|(13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;   
			   // var tel = /^\d{3,4}-?\d{7,9}$/;
				 var tel = /^\d{3,4}-?\d{7,9}(-\d{1,4})?$/; //可以包过分机号
			    return (tel.test(obj) || mobile.test(obj));
		},
		/*** 判断手机号是否正确 ****/
		isMobile:function(obj){
			   var mobile = /^(((18[0-9]{1})|(13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;   
			    return  mobile.test(obj);
		},
		/*** 判断电话号码是否正确 ****/
		isTel:function(obj){
			 var tel = /^\d{3,4}-\d{7,9}(-\d{1,4})?$/;  //可以包过分机号
			    return tel.test(obj) ;
		},
		/** 检查邮编是否正确**/
		isZipcode:function(obj){
			 var reg  =  /^[0-9]{6}$/;
			return  reg.test(obj);
		},
		/** 判断价格输入是否正确 */
		isPrice:function(obj){
			 //3为小数点
			var reg = /^(-?\d+)(\.\d{1,3})?$/;
			return reg.test(obj);
		},
		/** 判断是否数字***/
		isNumber:function(obj)  {
		  if(!obj) return false;  
		  var strP=/^\d+(\.\d+)?$/;  
		  if(!strP.test(obj)) return false;  
			  try{  
			  if(parseFloat(obj)!=obj) return false;  
			  } catch(ex) {  
		      return false;  
		     }  
		     return true;  
		  },
		/** 只能包括英文字母和数字 */
		onlyCharNum:function(obj){
			var reg = /^[a-zA-Z0-9]+$/;
			return reg.test(obj);
		},
		/** 只能包含数字 */
		onlyNum:function(obj){
			var reg = /^[0-9]+$/;
			return reg.test(obj);
		},
		/** 只能汉字 */
	   onlyChchar:function(obj){
			var reg =  /^[\u4e00-\u9fa5]+$/;
			return reg.test(obj);
		}
};















