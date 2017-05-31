<?
$username="root";
$password="";
$database="CTUBUSDATABASE";
$flag['code']=0;
$host="localhost";
$u=$_POST['uu'];
$p=$_POST['pp'];
$conn=mysql_connect($host,$username,$password);
mysql_select_db($database,$conn);
$query=mysql_query("select uname,password from Admin where uname='$u'and password='$p'",$conn);

while($row=mysql_fetch_array($query))
{
    $flag['code']=1;
}

print(json_encode($flag));
mysql_close($conn);
    

?>