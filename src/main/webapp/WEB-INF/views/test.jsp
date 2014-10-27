<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Test</title>
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
        <div style="height: 8px"></div>
        <div id="formDialog" title='<spring:message code="roles.data" />'>
            <form id="roleForm">
                <label for="callerInput">Caller</label>
                <span class="validateTips"></span>
                <input id="callerInput" name="callerInput" type="text" class="text ui-widget-content ui-corner-all" />
                <label for="phoneNumberInput">Phone Number</label>
                <span class="validateTips"></span>
                <input id="phoneNumberInput" name="phoneNumberInput" type="text" class="text ui-widget-content ui-corner-all" />
            </form>
            <button id="submit">Submit</button>
        </div>
        <script src="<c:url value="/resources/cosysUtils.js"/>"></script>
        <script>
            $(function() {
                /*fields are declares here and they are required by different functions*/
                var caller = $('#callerInput'),
                phoneNumber = $('#phoneNumberInput');
                var allFields = $([]).add(caller).add(phoneNumber);
                var CrudHandler = {};
                CrudHandler.newCall = function(){
                    /*if previously was any error*/
                    allFields.removeClass('ui-state-error');
                    var call = {};
                    call.caller = caller.val();
                    call.phoneNumber = phoneNumber.val();
                    var successCallback = function(xhr){
                        alert('submit done');
                        /*CrudHandler.refreshTable();*/
                    };
                    var errorCallback = function(xhr){
                        ExceptionHandler.handleAjax(xhr);
                    };
                    alert('submit');
                    //                        $.post('roleController/store',JSON.stringify(currentRole),callback,'json');
                    $.ajax(
                    { type: "POST",
                        url:'callController/submitCall',
                        data:JSON.stringify(call),
                        contentType: "application/json",
                        success:successCallback,
                        error:errorCallback
                    });
                };
                
                CrudHandler.init = function(){
                    /*to turn into jquery buttons al the button tags */            
                    $("button").button();
                    /*set refreshTable method in click event*/
                    $("#submit").click(function(event) {
                        CrudHandler.newCall();
                    });
                };
                CrudHandler.getTrSelected = function(oTableLocal){
                    var aReturn = null;
                    var aTrs = oTableLocal.fnGetNodes();
                    for(var i=0 ; i<aTrs.length ; i++ ){
                        if($(aTrs[i]).hasClass('row_selected')){
                            aReturn = aTrs[i];
                            break;
                        }
                    }
                    return aReturn;
                };
                CrudHandler.init();
            });
        </script>
    </body>
</html>