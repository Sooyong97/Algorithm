def solution(phone_number):
    phone_number = '*' * (len(phone_number)-4) + phone_number[-4:]
    return phone_number