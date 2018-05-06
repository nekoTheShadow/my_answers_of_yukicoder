if __name__ == '__main__':
    romans = ["I", "II", "III", "IIII", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"]
    
    s1, t = input().split()
    s2 = romans[(romans.index(s1) + int(t)) % len(romans)]
    print(s2)
