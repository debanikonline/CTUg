<?php

$host="localhost";
$username="root";
$password="";
$database="CTUBUSDATABASE";
$name=$_POST['name'];
//$name='IT PARK chd';
$conn=mysql_connect($host,$username,$password)or die ("not server");
mysql_select_db($database,$conn)or die ("not selected");
$query=mysql_query("SELECT DISTINCT busno from allotbus RIGHT OUTER JOIN stopage_detail on allotbus.routeid=stopage_detail.routeid where stopage_detail.stopname ='$name'",$conn) or die ("incorrect details");
while($row=mysql_fetch_array($query))
{
	$flag[]=$row;
	
}
print(json_encode($flag));
mysql_close($conn);
?>