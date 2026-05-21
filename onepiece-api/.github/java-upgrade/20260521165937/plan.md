# Upgrade Plan: onepiece-api (20260521165937)

- **Generated**: 2026-05-21 16:59:37
- **HEAD Branch**: main
- **HEAD Commit ID**: N/A

## Available Tools

**JDKs**
- JDK 17.0.15: C:\Program Files\Microsoft\jdk-17.0.15.6-hotspot\bin (current project base: java.version=17)
- JDK 21.0.7: C:\Program Files\Java\jdk-21\bin (required by upgrade step)

**Build Tools**
- Maven 3.9.9: C:\OpenSource\apache-maven-3.9.9\bin
- Maven Wrapper: 3.9.15 (configured in .mvn/wrapper/maven-wrapper.properties) — compatible with Java 21

## Guidelines

> Note: You can add any specific guidelines or constraints for the upgrade process here if needed, bullet points are preferred.

## Options

- Working branch: appmod/java-upgrade-20260521165937
- Run tests before and after the upgrade: true

## Upgrade Goals

- Upgrade Java runtime (project JVM target) to Java 21 (latest LTS)

## Technology Stack

| Technology/Dependency    | Current | Min Compatible | Why Incompatible |
| ------------------------ | ------- | -------------- | ----------------------------------------- |
| Java                     | 17      | 21             | User requested upgrade                    |
| Spring Boot (parent)     | 4.0.6   | 4.0.x          | 4.x supports Java 17+ and is compatible   |
| Maven (wrapper)          | 3.9.15  | 3.9.0+         | Required for Java 21 build support        |
| maven-compiler-plugin    | (not set) | 3.11.0       | Recommended for Java 21 bytecode support  |

## Derived Upgrades

- Update `java.version` property in `pom.xml` from `17` → `21`.
- Add/ensure `maven-compiler-plugin` version `3.11.0` in `pom.xml` if not present to guarantee proper bytecode target handling.

## Impact Analysis

### Dependency Changes

| File | Dependency | Current | Action | Target | Reason |
|------|------------|---------|--------|--------|--------|
| pom.xml | `java.version` property | 17 | upgrade | 21 | User requested Java LTS upgrade |
| pom.xml | `maven-compiler-plugin` (plugin) | not declared | add/upgrade | 3.11.0 | Ensure compiler supports Java 21 bytecode and source levels |

### Source Code Changes

No mandatory source code changes expected. Code compiled with Java 17 should generally be source-compatible with Java 21. If compilation or tests reveal API removals or illegal reflective access, they will be fixed in-step during execution.

### Configuration Changes

- `pom.xml`: update `java.version` to `21` and add `maven-compiler-plugin` configuration to enforce `source`/`target` `21`.

### CI/CD Changes

- If CI uses hardcoded Java versions, update CI pipeline/job files to use Java 21. (Not detected in repo root—update if present.)

### Risks & Warnings

- Reflection/internal API usage: code that relies on deep reflection into JDK internals may compile but fail at runtime under stronger encapsulation. Mitigation: run full test suite and address failures with reflection-safe rewrites or `--add-opens` workarounds (temporary) and then fix properly.
- Tests may surface framework incompatibilities. We'll fix test failures iteratively until all pass.

## Upgrade Steps

- Step 1: Setup Environment
  - **Rationale**: Ensure required JDK (21) and build tools are available on the machine.
  - **Changes to Make**: None — JDK 21 and Maven 3.9+ are already installed on the host; record paths.
  - **Verification**: Use JDK 21 to run `./mvnw -v` and `mvn -v`.

- Step 2: Setup Baseline
  - **Rationale**: Record current build and test status before changes.
  - **Changes to Make**: Run baseline build using current `java.version` (17) if available.
  - **Verification**: `mvn -DskipTests=false clean test-compile -q && mvn -q test` (JDK 17). Document pass rate.

- Step 3: Apply Java 21 configuration
  - **Rationale**: Update project POM to target Java 21 and ensure compiler plugin is configured.
  - **Changes to Make**: Edit `pom.xml` — set `<java.version>21</java.version>`; add `maven-compiler-plugin` with `source`/`target` 21 and plugin version 3.11.0.
  - **Verification**: `./mvnw -DskipTests=false -q clean test-compile` using JDK 21.

- Step 4: Fix compilation/test failures
  - **Rationale**: Resolve all compilation and test failures introduced by the upgrade.
  - **Changes to Make**: Apply source/code/config fixes as required (replace removed APIs, adjust reflective access, update test dependencies). Document each fix in `progress.md`.
  - **Verification**: Iteratively run `./mvnw -q clean test` until 100% pass rate.

- Step 5: Final Validation and commit
  - **Rationale**: Ensure all goals met and commit changes.
  - **Changes to Make**: Final run of full test suite; update CI if needed; commit on branch `appmod/java-upgrade-20260521165937`.
  - **Verification**: `./mvnw -DskipTests=false -q clean test` (JDK 21) — 100% tests pass.

---

If you approve this plan I will call the confirm tool to request your confirmation and then start executing Step 1 (update POM and run builds).