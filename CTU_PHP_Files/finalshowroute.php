<?php

$host="localhost";
$username="root";
$password="";
$database="CTUBUSDATABASE";
$numb=$_POST['numb'];
//$numb='102';
$conn=mysql_connect($host,$username,$password)or die ("not server");
mysql_select_db($database,$conn)or die ("not selected");
$query=mysql_query("SELECT DISTINCT stopname from stopage_detail RIGHT OUTER JOIN allotbus on stopage_detail.routeid=allotbus.routeid where allotbus.busno ='$numb'",$conn) or die ("incorrect details");
while($row=mysql_fetch_array($query))
{
	$flag[]=$row;
	
}
print(json_encode($flag));
mysql_close($conn);
?>