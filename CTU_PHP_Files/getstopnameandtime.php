<?
$username="root";
$password="";
$host="localhost";
$database="CTUBUSDATABASE";
$routeid=$_POST['routeid'];

$conn=mysql_connect($host,$username,$password);
mysql_select_db($database,$conn);
$query=mysql_query("select * from stopage_detail where routeid='$routeid'");
while($row=(mysql_fetch_array($query)))
{
    $flag[]=$row;
}
print(json_encode($flag));
mysql_close($conn);
?>