<?
$host="localhost";
$username="root";
$password="";
$database="CTUBUSDATABASE";
$conn=mysql_connect($host,$username,$password)or die ("not server");
mysql_select_db($database,$conn)or die ("not selected");
$query=mysql_query("select distinct stopname from stopage_detail",$conn);
while($row=mysql_fetch_array($query))
{
    $flag[]=$row;
}
print (json_encode($flag));
mysql_close($conn);
?>