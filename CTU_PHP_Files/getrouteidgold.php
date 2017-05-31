<?
$host="localhost";
$username="root";
$password="";
$database="CTUBUSDATABASE";
$routename=$_POST['routename'];
$conn=mysql_connect($host,$username,$password)or die ("not server");
mysql_select_db($database,$conn)or die ("not selected");
$query=mysql_query("select routeid from route_master where routename='$routename'",$conn);
while($row=mysql_fetch_array($query))
{
    $flag['routeid']=$row['routeid'];
}

print(json_encode($flag));
mysql_close($conn);
?>