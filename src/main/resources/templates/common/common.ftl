<#macro page>
<!doctype html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
    <style>
        body{
            background: #eef7ff url(static/img/Banner-Icon.jpg);
        }
    </style>
</head>
<body>
<#nested>
</body>
</html>
</#macro>