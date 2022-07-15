package models;

public class ProjectBuilder {
    private String name;
    private String code;
    private String description;


    public static class Builder {
        private ProjectBuilder newProject;

        public Builder() {
            newProject = new ProjectBuilder();
        }

        public ProjectBuilder.Builder withName(String name) {
            newProject.name = name;
            return this;
        }

        public ProjectBuilder.Builder withCode(String code) {
            newProject.code = code;
            return this;
        }

        public ProjectBuilder.Builder withDescription(String description) {
            newProject.description = description;
            return this;
        }

        public ProjectBuilder build() {
            return newProject;
        }
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ProjectBuilder{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
