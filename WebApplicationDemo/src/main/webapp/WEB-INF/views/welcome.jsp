<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <spring:url value="/resources/bootstrap.min.css" var="bootCss" />
  <spring:url value="/resources/bootstrap.min.js" var="bootJs" />
  <spring:url value="/resources/jquery.min.js" var="jqueryJs" />
  
  
  <link rel="stylesheet" href="${bootCss}">
  <script src="${jqueryJs}"></script>
  <script src="${bootJs}"></script>
  
  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   -->
  <script>
		function myFunction(){
		 var checkBox = document.getElementById("remember");
			if (checkBox.checked == true){

			document.getElementById('descpath').removeAttribute('readonly');
            document.getElementById('fileextm').removeAttribute('readonly');
		}else{
        	document.getElementById('descpath').setAttribute('readonly','readonly');
            document.getElementById('fileextm').setAttribute('readonly','readonly');
			}
		}
		
		function myFunction1(){
			document.getElementById('descpath').setAttribute('readonly','readonly');
            document.getElementById('fileextm').setAttribute('readonly','readonly');
		}
  </script>
  
</head>
<body onload="myFunction1()">

<div class="container">
  <h2>Horizontal form</h2>
  <form:form class="form-horizontal" action="savealert" modelAttribute="alert">
  
  	<div class="form-group">
      <label class="control-label col-sm-6" for="result"> <c:out value="${message}"/></label>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="hostname">Hostname</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="hostname" name="hostname" path="hostname" placeholder="Hostname" />
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="srcpath">Source path</label>
      <div class="col-sm-10">          
        <form:input type="text" class="form-control" id="srcpath" name="srcpath" path="srcpath" placeholder="Source path for validation"/>
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label><input type="checkbox" id="remember" name="remember"  onclick="myFunction()">Add validation to move files</label>
        </div>
      </div>
    </div>
    
    <div class="form-group" id="myDiv">
      <label class="control-label col-sm-2" for="descpath">Destination path</label>
      <div class="col-sm-10">          
        <form:input type="text" class="form-control" id="descpath" path="descpath" name="descpath" placeholder="destination path for validation"  readonly="readonly" />
      </div>
    </div>
    
     <div class="form-group">
      <label class="control-label col-sm-2" for="fileextm">File Extension</label>
      <div class="col-sm-10">          
        <form:input type="text" class="form-control" id="fileextm" path="fileextm" name="fileextm" placeholder="File extenstion to move or add * for all"  readonly="readonly"/>
      </div>
    </div>
    
      <div class="form-group">
      <label class="control-label col-sm-2" for="emailrecpt">Email Recipient Address</label>
      <div class="col-sm-10">          
        <form:input type="text" class="form-control" id="emailrecpt" name="emailrecpt" path="emailrecpt" placeholder="Email Address Seprated by ;" />
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form:form>
</div>

</body>
</html>

