from flask import Flask, request
from flask_restful import Resource, Api
from json import dumps
import subprocess
import requests

# Python 3


app = Flask(__name__)
api = Api(app)


class hack(Resource):
    def get(self):
        return {'get_success': 'true', 'data': request.data}

    def post(self):
        # subprocess.call('adb shell input tap', shell=True)
        return {'post_success': 'true', 'data': request.data}


api.add_resource(hack, '/hack')

if __name__ == '__main__':
    app.run(host='0.0.0.0')
