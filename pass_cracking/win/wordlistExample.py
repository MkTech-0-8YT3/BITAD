import bcrypt
import sys
import argparse

def get_wordlist_content(wordlist):
    with open(wordlist) as f:
        return f.read()

def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('-x', '--hash', help='Hash to crack', required=True)
    parser.add_argument('-w', '--wordlist', help='Wordlist', required=True)
    return parser.parse_args()

#TODO: Retreive salt from base hash
#Tip: salt chars are 22 characters after id and computation cost

def retreive_salt(full_hash):
    hash_parts = full_hash.split('$')
    return '$%s$%s$%s' % (hash_parts[1], hash_parts[2], hash_parts[3][:22])

def crack_pass(pass_to_crack, wordlist, salt):
    for passwd in get_wordlist_content(wordlist).split():
        processed_hash = bcrypt.hashpw(str(passwd).encode(), salt.encode())
        #TODO: Create hash with i
        print("Hash: %s\n pass: %s" % (processed_hash.decode("utf8"), passwd))
        if pass_to_crack == str(processed_hash.decode('utf8')):
            print("Found match! \n Password in cleartext: %s" % str(passwd))
            break

def main():
    args = parse_args()
    salt = retreive_salt(args.hash)
    crack_pass(args.hash, args.wordlist, salt)

if __name__ == "__main__":
	main()
