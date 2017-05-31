<?
$username="root";
$password="";
$database="CTUBUSDATABASE";
$host="localhost";
$user=$_POST['us'];
$pass=$_POST['ps'];
$conn=mysql_connect($host,$username,$password);
mysql_select_db($database,$conn);
$query=mysql_query("update UserDetails set cpassword='$pass' where cname='$user'",$conn);
mysql_close($conn);


?>