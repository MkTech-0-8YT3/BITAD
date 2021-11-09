import crypt
import sys

if len(sys.argv) != 2:
    print("Usage: %s <HashToCrack>" % sys.argv[0])


#TODO: Retreive salt from hash 
#Tip: split()

pass_split = sys.argv[1].split('$')
salt = '$%s$%s' % (pass_split[1], pass_split[2])
print(salt)
for i in range(1, 1000):
    processed_hash = crypt.crypt(str(i), salt)
    #TODO: Create hash with i
    print("Hash: %s\n pass: %s" % (processed_hash, i))
    if sys.argv[1] == processed_hash:
        print("Found match! \n Password in cleartext: %s" % str(i))
        break
