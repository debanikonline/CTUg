<?php
$username="root";
$password="";
$database="CTUBUSDATABASE";
$host="localhost";
$conn=mysql_connect($host,$username,$password) or die("CONNECTION NOT ESTABLISHED");
mysql_select_db($database,$conn) or die ("databse not selected");
$query=mysql_query("Select * from Admin",$conn);
while($row=mysql_fetch_array($query))
{
	$Flag[]=$row;	
}
print json_encode($Flag);
mysql_close($conn);

?>