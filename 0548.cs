using System;
using System.Linq;

namespace _548
{
    class Program
    {
        static void Main(string[] args)
        {
            var s = Console.ReadLine();

            var alphabets = "abcdefghijklm";
            var cnt = s.Distinct().Count(ch => alphabets.Contains(ch));

            if (cnt == 13)
            {
                foreach(var ch in alphabets)
                {
                    Console.WriteLine(ch);
                }
            }
            else if (cnt == 12)
            {
                var ch = alphabets.First(alphabet => !s.Contains(alphabet));
                Console.WriteLine(ch);
            }
            else
            {
                Console.WriteLine("Impossible");
            }
        }
    }
}
