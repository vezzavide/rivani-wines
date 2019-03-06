<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'ordine.label', default: 'Ordine')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-ordine" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <g:if test="${session.role == 'amministratore'}">
                    <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                </g:if>
            </ul>
        </div>
        <div id="show-ordine" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="ordine" />
            <g:form resource="${this.ordine}" method="DELETE">
                <fieldset class="buttons">
                    <g:if test="${session.role == 'amministratore'}">
                    <%-- show administrative functions --%>
                        <g:link class="edit" action="edit" resource="${this.ordine}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                        <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />

                    </g:if>

                    <g:if test="${this.ordine.dipendente == null}">
                        <g:link class="list" action="prendiInCarico" resource="${this.ordine}"><g:message code="default.button" default="Prendi in carico" /></g:link>
                    </g:if>
                    <g:else>
                        <g:link class="list" action="evadi" resource="${this.ordine}"><g:message code="default.button" default="Evadi" /></g:link>
                    </g:else>

                </fieldset>
            </g:form>
        </div>
    </body>
</html>
