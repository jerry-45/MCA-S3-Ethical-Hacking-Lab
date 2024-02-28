import hashlib

def crackHash(inputpass):
    try:
        passFile = open("Passwordlist.txt", "r")

    except:
        print("could not find file")

    for password in passFile:
        encPassword = password.encode("utf-8")
        digest = hashlib.md5(encPass.strip()).hexdigest()
        if digest == inputpass:
            print("Password Found: " + password)

if __name__=='__main__':
    crackHash("17aa1eb864dfc173fa7b67c05672591c")