<?php
$uname=$_POST['username'];
$spassword=$_POST['password'];

$username="root";
$password="";
$database="CTUBUSDATABASE";
$host="localhost";
$conn=mysql_connect($host,$username,$password) or die("CONNECTION NOT ESTABLISHED");
mysql_select_db($database,$conn) or die ("databse not selected");

mysql_query("insert into Admin (uname,password)values('$uname','$spassword')",$conn) or die ("insertion not completed");
echo "success";
    mysql_close($conn);

?>