<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Tool dipendente</title>
</head>
<body>

<g:if test="${flash.message}">
    <div class="alert alert-info" role="alert">
        ${flash.message}
    </div>
</g:if>


<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Rivani Wines - Strumenti dipendente</h1>


        <div id="controllers" role="navigation">
            <h2>Operazioni disponibili:</h2>
                <g:link controller="fornitura" action="create">
                    <button type="button" class="btn btn-primary btn-lg">Aggiungi nuova fornitura</button>
                </g:link>
            <br/><br/>
                <g:link controller="ordine" action="indexOrdiniDaPrendereInCarico">
                    <button type="button" class="btn btn-primary btn-lg">Elenco ordini da evadere non ancora presi in carico</button>

                </g:link>
            <br/><br/>
                <g:link controller="ordine" action="indexOrdiniDaEvadere">
                    <button type="button" class="btn btn-primary btn-lg">Elenco ordini già presi in carico in attesa di essere evasi</button>

                </g:link>
            <br>
        </div>
        <br>
    </section>
    <br>
</div>

</body>
</html>
