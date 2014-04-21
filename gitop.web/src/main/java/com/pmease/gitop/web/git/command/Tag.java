package com.pmease.gitop.web.git.command;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.annotation.Nullable;

import com.google.common.base.Strings;
import com.pmease.commons.git.GitContrib;

public class Tag implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String name;
	private final String hash;
	private final String commitHash;
	private final GitContrib tagger;
	private final String subject;
	private final String body;

	public static class Builder {
		private String name;
		private String hash;
		private String commitHash;
		private GitContrib tagger;
		private String subject;
		private String body;
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder hash(String hash) {
			this.hash = hash;
			return this;
		}
		
		public Builder commitHash(String commitHash) {
			this.commitHash = commitHash;
			return this;
		}
		
		public Builder tagger(GitContrib tagger) {
			this.tagger = tagger;
			return this;
		}
		
		public Builder subject(String subject) {
			this.subject = subject;
			return this;
		}
		
		public Builder body(String body) {
			this.body = body;
			return this;
		}
		
		public Tag build() {
			return new Tag(name, hash, commitHash, tagger, subject, body);
		}
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	Tag(String name, String hash, @Nullable String commitHash, 
			GitContrib tagger, String subject, @Nullable String body) {
		this.name = checkNotNull(name, "name"); 
		this.hash = checkNotNull(hash, "hash");
		this.commitHash = commitHash;
		this.tagger = tagger;
		this.subject = checkNotNull(subject, "subject");
		this.body = body;
	}

	public String getName() {
		return name;
	}

	public String getHash() {
		return hash;
	}

	public String getCommitHash() {
		return commitHash;
	}

	public GitContrib getTagger() {
		return tagger;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

	public String getMessage() {
		return Strings.isNullOrEmpty(body) ? subject : subject + "\n" + body;
	}
	
	public String getSha() {
		return Strings.isNullOrEmpty(commitHash) ? hash : commitHash;
	}
}
