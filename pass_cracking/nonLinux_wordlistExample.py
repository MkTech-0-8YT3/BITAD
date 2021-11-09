import bcrypt
import sys

def get_wordlist_content(wordlist):
    with open(wordlist) as f:
        return f.read()

if len(sys.argv) != 2:
    print("Usage: %s <HashToCrack> <wordlist>" % sys.argv[0])

#TODO: Retreive salt from base hash
#Tip: salt chars are 22 characters after id and computation cost

hash_parts = sys.argv[1].split('$')
salt = '$%s$%s$%s' % (hash_parts[1], hash_parts[2], hash_parts[3][:22])
print(salt)

for i in get_wordlist_content(sys.argv[2]).split():
    processed_hash = bcrypt.hashpw(str(i).encode(), salt.encode())
    #TODO: Create hash with i
    print("Hash: %s\n pass: %s" % (processed_hash.decode("utf8"), i))
    if sys.argv[1] == str(processed_hash.decode('utf8')):
        print("Found match! \n Password in cleartext: %s" % str(i))
        break
