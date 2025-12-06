import pandas as pd


df = pd.read_csv("student_preferences.csv")


df = df.assign(preferred_courses=df['preferred_courses'].str.split(';')).explode('preferred_courses')


course_demand = df['preferred_courses'].value_counts().reset_index()
course_demand.columns = ['course', 'student_count']

print("📊 Course Demand:")
print(course_demand)


gpa_stats = df.groupby('preferred_courses')['gpa'].agg(['mean', 'min', 'max']).reset_index()
gpa_stats.columns = ['course', 'avg_gpa', 'min_gpa', 'max_gpa']

print("\n📈 GPA Stats by Course:")
print(gpa_stats)

course_analysis = pd.merge(course_demand, gpa_stats, on='course')

print("\n✅ Final Course Analysis:")
print(course_analysis)

course_analysis.to_csv("course_analysis.csv", index=False)
