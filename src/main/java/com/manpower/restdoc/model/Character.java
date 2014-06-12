/**
 * 
 */
package com.manpower.restdoc.model;

/**
 * @author acogoluegnes
 *
 */
public class Character {

	private Long id;
	
	private String name;
    private String movie;

    public Character(Long id, String name, String movie) {
        this.id = id;
        this.name = name;
        this.movie = movie;
    }

    public Character() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
