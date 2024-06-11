from flask import Flask, jsonify, request
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///mercado.db'
db = SQLAlchemy(app)

class Comprador(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(50), nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)
    password = db.Column(db.String(80), nullable=False)

    def __repr__(self):
        return f"Comprador('{self.name}', '{self.email}')"

class Producer(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(50), nullable=False)
    regiao = db.Column(db.String(50), nullable=False)
    contato = db.Column(db.String(120), nullable=False)
    qtd = db.Column(db.Integer, nullable=False)
    valor = db.Column(db.Float, nullable=False)
    descricao = db.Column(db.Text, nullable=False)

    def __repr__(self):
        return f"Producer('{self.nome}', '{self.regiao}', '{self.qtd}', '{self.valor}')"

class Vendedor(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(50), nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)
    password = db.Column(db.String(80), nullable=False)

    def __repr__(self):
        return f"Vendedor('{self.name}', '{self.email}')"

@app.route('/api/compradores', methods=['GET', 'POST'])
def compradores():
    if request.method == 'POST':
        data = request.get_json()
        comprador = Comprador(name=data['name'], email=data['email'], password=data['password'])
        db.session.add(comprador)
        db.session.commit()
        return jsonify({'message': 'Comprador criado com sucesso'}), 201
    
    db.create_all()
    compradores = Comprador.query.all()
    output = []
    for comprador in compradores:
        comprador_data = {'id': comprador.id, 'name': comprador.name, 'email': comprador.email}
        output.append(comprador_data)
    
    return jsonify({'compradores': output})

@app.route('/api/producers', methods=['GET', 'POST'])
def producers():
    if request.method == 'POST':
        data = request.get_json()
        producer = Producer(nome=data['nome'], regiao=data['regiao'], contato=data['contato'], 
                            qtd=data['qtd'], valor=data['valor'], descricao=data['descricao'])
        db.session.add(producer)
        db.session.commit()
        return jsonify({'message': 'Producer criado com sucesso'}), 201
    
    db.create_all()
    producers = Producer.query.all()
    output = []
    for producer in producers:
        producer_data = {'id': producer.id, 'nome': producer.nome, 'regiao': producer.regiao, 
                         'contato': producer.contato, 'qtd': producer.qtd, 'valor': producer.valor, 
                         'descricao': producer.descricao}
        output.append(producer_data)
    
    return jsonify({'producers': output})

@app.route('/api/vendedors', methods=['GET', 'POST'])
def vendedors():
    if request.method == 'POST':
        data = request.get_json()
        vendedor = Vendedor(name=data['name'], email=data['email'], password=data['password'])
        db.session.add(vendedor)
        db.session.commit()
        return jsonify({'message': 'Vendedor criado com sucesso'}), 201
    
    db.create_all()
    vendedors = Vendedor.query.all()
    output = []
    for vendedor in vendedors:
        vendedor_data = {'id': vendedor.id, 'name': vendedor.name, 'email': vendedor.email}
        output.append(vendedor_data)
    
    return jsonify({'vendedors': output})

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
