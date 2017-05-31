<?
$host="localhost";
$username="root";
$password="";
$database="CTUBUSDATABASE";
$conn=mysql_connect($host,$username,$password)or die ("not server");
mysql_select_db($database,$conn)or die ("not selected");
//$query=mysql_query("select routename from route_master",$conn);
$query=mysql_query("SELECT routename,busno from route_master,allotbus where route_master.routeid=allotbus.routeid");
while($row=mysql_fetch_array($query))
{
    $flag[]=$row;
}
print(json_encode($flag));
mysql_close($conn);
?>