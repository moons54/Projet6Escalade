package org.bean.topo.projetp6;

public class Message_voie {
	private int _iD;
	public Voie _voies;
	public Message _messages;

	public void setVoies(Voie aVoies) {
		this._voies = aVoies;
	}

	public Voie getVoies() {
		return this._voies;
	}

	public void setMessages(Message aMessages) {
		this._messages = aMessages;
	}

	public Message getMessages() {
		return this._messages;
	}

	public int get_iD() {
		return _iD;
	}

	public void set_iD(int _iD) {
		this._iD = _iD;
	}

	public Voie get_voies() {
		return _voies;
	}

	public void set_voies(Voie _voies) {
		this._voies = _voies;
	}

	public Message get_messages() {
		return _messages;
	}

	public void set_messages(Message _messages) {
		this._messages = _messages;
	}
}