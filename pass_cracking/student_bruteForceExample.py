import crypt
import sys

if len(sys.argv) != 2:
    print("Usage: %s <HashToCrack>" % sys.argv[0])


#TODO: Retreive salt from hash 
#Tip: split()

hash_parts = sys.argv[1]#Complete


for i in range(1, 1000):
    #TODO: Create hash with i and salt
    #Tip: crypt.crypt(pass, salt)
    if sys.argv[1] == processed_hash:
        print("Found match! \n Password in cleartext: %s" % str(i))
        break
