using System;
using System.Linq;

namespace _588
{
    class Program
    {
        static void Main(string[] args)
        {
            var str = Console.ReadLine();
            int answer = 0;
            for (int start = 0, len = str.Count(); start < len; start++)
            {
                for (int end = start; end < len; end++)
                {
                    if (str[start] != str[end])
                    {
                        continue;
                    }

                    int count = 0;
                    for (int x = start, y = end; x <= end; x++, y--)
                    {
                        if (str[x] == str[y])
                        {
                            count++;
                        }
                    }

                    answer = Math.Max(answer, count);
                }
            }

            Console.WriteLine(answer);
        }
    }
}
