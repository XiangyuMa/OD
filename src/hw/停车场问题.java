package hw;

import java.util.Scanner;

public class 停车场问题 {

    /**
     * 停⻋场问题，⼀个1表示⼩轿⻋，两个1表示⼤巴⻋，三个1表示⼤卡⻋，0表示空。给
     * ⼀个由若⼲个1和若⼲个0组成的数组（如{1,0,1,1,0,1,1,1,1,1,0}）表示的停⻋场，求这
     * 个停⻋场最少由⼏辆⻋。解题思路：我们只需要让⻋尽量⼤就可以了。遍历数组，使⽤
     * ⼀个临时变量来存储当前累计的1的个数，当计数到达3或者获取到0的时候，临时变量
     * 清零，并把⻋辆个数加⼀。数组遍历完成后检查临时变量，如果临时变量不为1，则计
     * 数再加⼀（因为当数组不以0结尾或者最后只有不到三个1时，就会出现⼀辆⻋没有被
     * 计数）。
     */
    public	static	void	main(String[]	args)	{
        Scanner in	=	new	Scanner(System.in);
        String[] str =	in.nextLine().split(",");
        String	s	=	"";
        for	(String	st	:	str)	{
            s	+=	st;
        }
        String[]	newStr	=	s.split("0");
        int	count	=	0;
        for	(int	i	=	0;	i	<	newStr.length;	i++)	{
            int	length	=	newStr[i].length();
            if	(length	==	0)	{
                continue;
            }
            if	(length	%	3	!=	0)	{
                count	+=	(length	- length	%	3)	/	3	+	1;
            }	else	{
                count	+=	length	/	3;
            }
        }
        System.out.println(count);
    }
}

