<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<style type="text/css">
    .tab1 {
        padding-left: 2em;
    }
</style>

<div class="tab1">
    <b>Links for ${product.name}</b>
    <ul>
        <c:forEach var="deepLink" items="${deepLinks}">
            <li><a href="${deepLink.url}">${deepLink.name}</a></li>
        </c:forEach>
    </ul>
</div>

<c:url value="/view/DeepLinkCMSComponentController/addLink" var="formAction"/>

<script type="text/javascript" src="/yacceleratorstorefront/_ui/responsive/common/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        var deepLinkForm = $("#deepLinkForm");
        var submitButton = $("#submitButton");
        var result = $("#resultContainer");
        
        submitButton.click(function () {
            deepLinkForm.ajaxSubmit(function (data) {
                result.innerHTML = data.toString();
                deepLinkForm.trigger("reset");
            });
        });
    });
</script>

<div id="resultContainer" style="display: none;"></div>

<div>
    <b>Add new Link:</b>
    <form:form id="deepLinkForm" action="${formAction}" method="POST" modelAttribute="deepLink">
        <table>
            <tr>
                <td><form:label path="name">Name</form:label>
                    <form:input path="name"/></td>
            </tr>
            <tr>
                <td><form:label path="url">URL</form:label>
                    <form:input path="url"/></td>
            </tr>
            <form:hidden path="productCode" value="${product.code}"/>
            <tr>
                <td><input id="submitButton" type="button" value="Submit"/></td>
            </tr>
        </table>
    </form:form>
</div>