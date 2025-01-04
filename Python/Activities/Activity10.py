numbers = list(input("Enter the numbers sepated by space : ").split(" "))
for i in numbers:
    if(int(i)%5 == 0):
        print(i ,end = " ")