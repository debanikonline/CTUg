<?php
$flag;
$host="localhost";
$username="root";
$password="";
$database="CTUBUSDATABASE";
$user=$_POST['cname'];
//$user="debanisssk3";
$conn=mysql_connect($host,$username,$password)or die ("not server");
mysql_select_db($database,$conn)or die ("not selected");
$query=mysql_query("select cname from UserDetails where cname='$user'",$conn) or die ("incorrect details");
$u1="";
while($row=mysql_fetch_array($query))
{
	$u1=$row["cname"];
	
}
if($user!=null)
{
if($u1==$user)
{
	$flag['code']=1;
	
}
    else
    {
        
        $flag['code']=0;
    }
}

print(json_encode($flag));
mysql_close($conn);
?>