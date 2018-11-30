<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/head-tag.jsp"%>

<%@ include file="/header.jsp"%>
<body>


<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <style>
        body{
            font-family: "Trebuchet MS", sans-serif;
            margin: 50px;
        }
        .demoHeaders {
            margin-top: 2em;
        }
        #dialog-link {
            padding: .4em 1em .4em 20px;
            text-decoration: none;
            position: relative;
        }
        #dialog-link span.ui-icon {
            margin: 0 5px 0 0;
            position: absolute;
            left: .2em;
            top: 50%;
            margin-top: -8px;
        }
        #icons {
            margin: 0;
            padding: 0;
        }
        #icons li {
            margin: 2px;
            position: relative;
            padding: 4px 0;
            cursor: pointer;
            float: left;
            list-style: none;
        }
        #icons span.ui-icon {
            float: left;
            margin: 0 4px;
        }
        .fakewindowcontain .ui-widget-overlay {
            position: absolute;
        }
        select {
            width: 200px;
        }
    </style>
</head>

<div>
    <h3>Please choose desired setting for test...</h3>
    <br>
    <form action="test/start" method="post">
        Number of menu items to be tested on:
        <br>
        <select name="testSize">
            <option value="10">10</option>
            <option value="15">15</option>
            <option value="20">20</option>
            <option value="25">25</option>
        </select>
        <br>
        Popularity of menu items to be tested:
        <br>
            <input type="radio" name="freq" value="1" checked>High<br>
            <input type="radio" name="freq" value="2"> Med<br>
            <input type="radio" name="freq" value="3"> Low
        <br>
        Order vocabulary verbage:
        <br>
            <input type="radio" name="language" value="normal" checked>Normal order descriptions<br>
            <input type="radio" name="language" value="slang"> Slang or alternative descriptions<br>
        <br>
        <br>
        <input type="submit" name="submit" value="Start test">

    </form>
</div>

</body>
</html>