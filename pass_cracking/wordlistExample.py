import crypt
import sys

def get_wordlist_content(wordlist):
    with open(wordlist) as f:
        return f.read()

if len(sys.argv) != 3:
    print("Usage: %s <HashToCrack> <Wordlist>" % sys.argv[0])


#TODO: Retreive salt from hash 
#Tip: split()

pass_split = sys.argv[1].split('$')
salt = '$%s$%s' % (pass_split[1], pass_split[2])
print(salt)
for i in get_wordlist_content(sys.argv[2]).split():
    processed_hash = crypt.crypt(str(i), salt)
    #TODO: Create hash with i
    print("Hash: %s\n pass: %s" % (processed_hash, i))
    if sys.argv[1] == processed_hash:
        print("Found match! \n Password in cleartext: %s" % str(i))
        break
