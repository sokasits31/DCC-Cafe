<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/head-tag.jsp"%>

<%@ include file="/header.jsp"%>
<body>


<head>
    !--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

</head>



<table cellpadding="15" width="800" align="center">
    <col width="500">
    <col width="300">
    <tr>
        <td colspan="2">
            <h2>Welcome!</h2>
        </td>
    </tr>
    <tr>
        <td >
            Thanks for showing interest in volunteering to help out in the cafe.  To help with
            make you first day a success, please create a login id.  This logon id will allow the
            cafe manager access to your email and phone information.  It will also allow you
            to practice entering orders in on a register simulator.  The goal of the simulator
            is to to allow voluenteers to establish/refresh skills on the register.
        </td>
        <td>
            <div style="background-color:lightblue">
                <h4>Volunteers and/or Admin....</h4>
                <ul>
                    <li> <A HREF="admin">Access Admin Functions</A></li>
                    <li> <A HREF="simulator/settings">Start Test Simulator</A></li>
                </ul>
            </div>
        </td>

    </tr>
</table>



<%@ include file="/footer.jsp"%>

</body>
</html>