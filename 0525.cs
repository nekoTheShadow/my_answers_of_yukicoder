using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

class Program
{
    static void Main(string[] args)
    {
        var tokens = Console.ReadLine().Split(':').Select(int.Parse).ToArray();
        var hh = tokens[0];
        var mm = tokens[1];

        var date = new DateTime(2017, 10, 4, hh, mm, 0).AddMinutes(5);
        Console.WriteLine(date.ToString("HH:mm"));
    }
}
