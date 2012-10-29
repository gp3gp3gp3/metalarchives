package de.loki.metallum.entity;

import de.loki.metallum.enums.DiscType;

public class Track extends AbstractEntity {

	private Disc	discFromTrack;
	private boolean	instrumental	= false;

	private String	lyrics			= "";
	private String	playTime;
	private int		trackNumber;
	private String	splitBandName	= "";
	private int		discNumber		= 1;

	/**
	 * the Track will always have the id from the Disc!
	 * 
	 * @param id
	 */
	public Track(final long id) {
		super(id);
		this.discFromTrack = new Disc(id);
	}

	public Track() {
		super(0);
		this.discFromTrack = new Disc(0);
	}

	public void setDiscName(String discName) {
		this.discFromTrack.setName(discName);
	}

	public String getBandName() {
		if (this.discFromTrack.isSplit()) {
			return this.splitBandName;
		} else {
			return this.discFromTrack.getBand().getName();
		}
	}

	// exists because there are also split discs, and we have no chance to determine which track is
	// from which band
	public void setBandName(String bandName) {
		this.splitBandName = bandName;
	}

	public String getPlayTime() {
		return this.playTime;
	}

	public int getTrackNumber() {
		return this.trackNumber;
	}

	public boolean isInstrumental() {
		return this.instrumental;
	}

	public void setDiscType(DiscType discType) {
		this.discFromTrack.setDiscType(discType);
	}

	public Disc getDiscOfThisTrack() {
		return this.discFromTrack;
	}

	public void setGenre(String genre) {
		this.discFromTrack.getBand().setGenre(genre);
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public Band getBand() {
		return this.discFromTrack.getBand();
	}

	public String getGenre() {
		return this.discFromTrack.getGenre();
	}

	public String getLyrics() {
		return this.lyrics;
	}

	public DiscType getDiscTyp() {
		return this.discFromTrack.getType();
	}

	public void setPlayTime(final String playTime) {
		this.playTime = playTime;
	}

	public void setTrackNumber(final int trackNo) {
		this.trackNumber = trackNo;
	}

	public void setInstrumental(final boolean b) {
		this.instrumental = b;
	}

	public void setDiscNumber(final int discNumber) {
		this.discNumber = discNumber;
		if (this.discFromTrack.getDiscCount() < discNumber) {
			this.discFromTrack.setDiscCount(discNumber);
		}
	}

	public int getDiscNumber() {
		return this.discNumber;
	}

	public String getDiscName() {
		return this.discFromTrack.getName();
	}

	public void setDisc(final Disc disc) {
		this.discFromTrack = disc;
	}

	public Disc getDisc() {
		return this.discFromTrack;
	}

}
