<?php
$username='root';
$password="";
$host="localhost";
$database="CTUBUSDATABASE";
$conn=mysql_connect($host,$username,$password);
mysql_select_db($database,$conn);
$query=mysql_query("insert into stopage_detail(stopid,stopname,stoptime,routeid)values(12,'It-park',1220,11)",$conn);
mysql_close($conn);
?>