<?php
$host="localhost";
$username="root";
$password="";
$database="CTUBUSDATABASE";
$u=$_POST['username'];
$p=$_POST=['password'];
$conn=mysql_connect($host,$username,$password);
mysql_select_db($database,$conn);
mysql_query("update Admin set password='$p' where uname='$u'",$conn);
echo "success";
?>