<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title>Calls</title>
        <style>
            td.right{text-align: right}
        </style>
        <link href="<c:url value="/resources/jquery-ui-1.9.2/css/dark-hive/jquery-ui-1.9.2.custom.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/DataTables-1.9.4/media/css/demo_table_jui.css" />" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/jquery-ui-1.9.2/development-bundle/demos/demos.css" />" rel="stylesheet" type="text/css"/>
        <!--<link href="<c:url value="/resources/psb.css" />" rel="stylesheet" type="text/css"/>-->

        <!--for development sale-->
        <!--<link href="<c:url value="/resources/jquery-ui-1.9.2/development-bundle/themes/dark-hive/jquery.ui.all.css" />" rel="stylesheet" type="text/css"/>-->

        <!--js-->
        <!--It must be before any ui js-->
        <script src="<c:url value="/resources/jquery-ui-1.9.2/development-bundle/jquery-1.8.3.js"/>"></script>

        <!--This includes all the js ui files use it instead of resources/jquery-ui-1.9.2/development-bundle/ui/*-->
        <script src="<c:url value="/resources/jquery-ui-1.9.2/js/jquery-ui-1.9.2.custom.js"/>"></script>
    </head>
    <body>
        <button id="refreshButton">Refresh</button>
        <div id="messages"></div>
        <script src="<c:url value="/resources/cosysUtils.js"/>"></script>
        <script>
            $(function() {        
                var CrudHandler = {};
                CrudHandler.updateStatus = function(){
                    $("#messages").dialog('open');
                };    
                CrudHandler.pool = function(){
                    var successCallback = function(data){
                        if(data!==''){
//                            alert(data);  // process results here
                        }
                        setTimeout(CrudHandler.pool,5000);
                    };
                    var errorCallback = function(xhr){
                        ExceptionHandler.handleAjax(xhr);
                        if(isNew){
                            currentRole = null;
                        }
                    };
                    $.ajax(
                    { type: "POST",
                        url:'callController/newCalls',
                        contentType: "application/json",
                        success:successCallback,
                        error:errorCallback
                    });
                };
                CrudHandler.pool();
            });
        </script>
    </body>
</html>