<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/3
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="../static/jquery-3.4.1.min.js"></script>



<html>
<head>
    <title>DeptList</title>
</head>
<body>

    <button id="btn">按钮</button>




    <script type="text/javascript">

        $("#btn").click(function(){
            console.log("qaq")
            alert("asda")
        })

        $(function () {
            $.ajax({
                url:"/deptController/findEmpList",
                data:{pageNo:1,date:new Date()},
                type:"GET",
                dataType: "json",
                success:function (result) {
                    debugger
                    var data = result.records;
                    if(result.success){
                        alert("查询成功")
                    }else{
                        alert(result.message)
                    }
                },
                error:function (erro) {
                    alert("查询错误")
                }
            })
        })

    </script>

</body>

</html>
