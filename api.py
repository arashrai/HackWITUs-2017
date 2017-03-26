from flask import Flask, request
from flask_restful import Resource, Api
from json import dumps

# Create a engine for connecting to SQLite3.
# Assuming salaries.db is in your app root folder


app = Flask(__name__)
api = Api(app)


class hack(Resource):
    def get(self):
        return {'posted': 3}

    def post(self):
        return {'posted': 1}


api.add_resource(hack, '/hack')

if __name__ == '__main__':
    app.run(host='0.0.0.0')
