import bcrypt
import sys
import argparse

def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('-x', '--hash', help='Hash to crack', required=True)
    return parser.parse_args()

#TODO: Retreive salt from base hash
#Tip: salt chars are 22 characters after id and computation cost

def retreive_salt(full_hash):
    hash_parts = full_hash.split('$')
    return '$%s$%s$%s' % (hash_parts[1], hash_parts[2], hash_parts[3][:22])

def crack_pass(hash_to_crack, salt):
    for i in range(1, 1000):
        processed_hash = bcrypt.hashpw(str(i).encode(), salt.encode())
        #TODO: Create hash with i
        print("Hash: %s\n pass: %s" % (processed_hash.decode("utf8"), i))
        if hash_to_crack == str(processed_hash.decode('utf8')):
            print("Found match! \n Password in cleartext: %s" % str(i))
            break

def main():
    args = parse_args()
    salt = retreive_salt(args.hash)
    crack_pass(args.hash, salt)

if __name__ == "__main__":
    main()
