<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/10/24
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HelloAjax</title>

    <script type="text/javascript">
        window.onload = function(){
            //1.获取a节点，添加单击事件响应函数
            document.getElementsByTagName("a")[0].onclick = function () {
                //3.创建XMLHttpRequest对象
                var request = new XMLHttpRequest();
                //4.准备发送的数据：URL
                var method = "GET";
                var url = this.href + "?time=" + new Date();//url加个时间，起到类似禁用缓存的效果
                //5.调用对象的open方法
                request.open(method,url);
                //6.调用send方法
                request.send(null);
                //7.为对象添加响应函数
                request.onreadystatechange = function () {
                    //8.readyState为4时，响应完成
                    if(request.readyState == 4){
                        //9.status为200或者304时，响应可用
                        if(request.status == 200 || request.status == 304){
                            //10.打印响应结果
                            alert(request.responseText);
                        }
                    }
                }
                //2.取消a节点的默认行为
                return false;
            }
        }
    </script>
</head>
<body>
    <a href="../../HelloAjax.txt">Hello</a>
</body>
</html>
