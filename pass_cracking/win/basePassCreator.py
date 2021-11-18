import bcrypt
import sys

if len(sys.argv) != 2:
    print("Usage: %s <PassClearText>" % sys.argv[0])
    sys.exit(-1)

salt = bcrypt.gensalt()
pass_hash = bcrypt.hashpw(sys.argv[1].encode(), salt)

print("Pass: %s" % sys.argv[1])
print("Salt: %s" % salt.decode('utf-8'))
print("Hash: %s" % pass_hash.decode('utf-8'))
